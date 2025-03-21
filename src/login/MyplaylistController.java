package login;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.MakeMusicBox;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.ChartDAO;

public class MyplaylistController implements Initializable {

	private ChartDAO Dao;
	private ArrayList<MYplayListDTO> musicList;
//	private Parent form;
	private ObservableList<Node> fp;

	private File directorySongImg;
	private File[] fileSongImg;
	private ArrayList<File> songsImg;
	private String dbtitle;

	@FXML
	private FlowPane listPane;

	public void initialize(URL location, ResourceBundle resources) {
		Dao = new ChartDAO();
		MakeMusicBox MMB = new MakeMusicBox();
		
		musicList = Dao.selectMYplaylist(); 
		fp = listPane.getChildren();
		for (MYplayListDTO myDto : musicList) {
			String singer = myDto.getSinger();
			String dbtitle = myDto.getTitle();

			fp.add(MMB.eachSong(singer, dbtitle, false));
		}

	}

//	public Image musicPlay(String dbSinger, String dbTitle) {
//		songsImg = new ArrayList<File>();
//		directorySongImg = new File("musicAlbum");
//		fileSongImg = directorySongImg.listFiles();
//		
//		if (fileSongImg != null) { // 폴더 노래가 없을 때까지 반복
//			for (File file : fileSongImg) {
//				songsImg.add(file);		
//			}
//		}
//		
//		for (File file : songsImg) {
//			String imgText = file.getName();
//			String[] parts = imgText.split("-|\\."); // ("-")를 기준으로 문자열 분할
//
//			String imgTitle = parts[1]; // 두 번째 제목 호출
////			String imgSinger = parts[0]; // 첫 번째 가수 호출
//			if (dbtitle.equals(imgTitle)) {
//				// 앨범 이미지 삽입
//				System.out.println("if문 안"+file.getName());
//				String albumURL = dbSinger + "-" + dbtitle + ".jpg";
//				Image AlbumImage = new Image("/musicAlbum/" + albumURL);
//		
//				return AlbumImage;
//			}
//		}
//		
//
//		return null;
//	}
//
//	public HBox eachSong(String dbSinger, String dbTitle) {
//		HBox songContainer = new HBox();
//		songContainer.setPrefWidth(550.0);
//		songContainer.setMaxHeight(50.0);
//		songContainer.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
//		songContainer.setStyle("-fx-background-color: white;");
//
//		VBox numBox = new VBox();
//		numBox.setPrefSize(33.0, 50.0);
//		numBox.setAlignment(Pos.CENTER);
//
//		VBox AlbumCoverBox = new VBox();
//		AlbumCoverBox.setPrefSize(100.0, 200.0);
//		AlbumCoverBox.setAlignment(Pos.CENTER);
//		ImageView coverImg = new ImageView(musicPlay(dbSinger, dbTitle));
//
//		coverImg.setFitHeight(50);
//		coverImg.setFitWidth(52);
//		AlbumCoverBox.getChildren().add(coverImg);
//
//		VBox songInfo = new VBox();
//		songInfo.setPrefSize(297.0, 50.0);
//		songInfo.setSpacing(5.0);
//		songInfo.setAlignment(Pos.CENTER_LEFT);
//		Label title = new Label(dbTitle);
//		Label singer = new Label(dbSinger);
//		songInfo.getChildren().addAll(title, singer);
//		
//		VBox playBox = new VBox();
//		ImageView playBtn = new ImageView("img/playButton.png");
//		
//		playBox.setPrefSize(51.0, 50.0);
//		playBtn.setFitHeight(24.0);
//		playBtn.setFitWidth(21.0);
//		playBox.setAlignment(Pos.CENTER);
//		playBox.getChildren().add(playBtn);
//
//		songContainer.getChildren().addAll(numBox, AlbumCoverBox, songInfo, playBox);
//
//		return songContainer;
//	}
}
