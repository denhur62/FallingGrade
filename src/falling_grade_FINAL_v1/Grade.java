package falling_grade_FINAL_v1;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Grade extends Thread {
	private Image gradeImage;
	private boolean proceeded = true;
	private int x, y = 50;
	private int gradeType, speed;
	// 0 : A
	// 1 : B
	// 2 : C
	// 3 : D
	// 4 : F

	public boolean isProceeded() {
		return proceeded;
	}

	public void close() {
		proceeded = false;
	}

	Random generator = new Random();

	public Grade(int gradeType) {
		// 임시 학점 이미지 생성
		if (gradeType == 0) {
			gradeImage = new ImageIcon(".\\bin\\Image\\4.0.png").getImage();
		} else if (gradeType == 1) {
			gradeImage = new ImageIcon(".\\bin\\Image\\3.0.png").getImage();
		} else if (gradeType == 2) {
			gradeImage = new ImageIcon(".\\bin\\Image\\2.0.png").getImage();
		} else if (gradeType == 3) {
			gradeImage = new ImageIcon(".\\bin\\Image\\1.0.png").getImage();
		} else if (gradeType == 4) {
			gradeImage = new ImageIcon(".\\bin\\Image\\0.png").getImage();
		}
		this.speed = 2 + generator.nextInt(5);
		this.x = generator.nextInt(951);
		this.gradeType = gradeType;
	}

	public void screenDraw(Graphics g) {
		g.drawImage(gradeImage, x, y, null);
	}

	public void drop() {
		y += this.speed;
		int playerX = FallingGrade.player.getX();
		Music coin = new Music("coin.mp3",false);
		if ((y >= 575) && (y < 800) && (x >= playerX - 50) && (x <= playerX + 150)) {
			if (this.gradeType == 0) { // A 먹은 경우
				
				coin.start();
				Main.GRADE_COUNT += 1;
				Main.TOTAL_SCORE += 4;
				
				

			} else if (this.gradeType == 1) { // B 먹은 경우
				coin.start();
				Main.GRADE_COUNT += 1;
				Main.TOTAL_SCORE += 3;
				
			} else if (this.gradeType == 2) { // C 먹은 경우
				coin.start();
				Main.GRADE_COUNT += 1;
				Main.TOTAL_SCORE += 2;
				

			} else if (this.gradeType == 3) { // D 먹은 경우
				coin.start();
				Main.GRADE_COUNT += 1;
				Main.TOTAL_SCORE += 1;
				

			} else { // F 먹은 경우
				Main.FCOUNT += 1;
				coin.start();
				if (Main.FCOUNT == 3) {
					
					Main.GAME_START = false;
					FallingGrade.page4 = false;
					FallingGrade.gameoverPage = true;
				}
			}
			Main.SCORE = Main.TOTAL_SCORE / Main.GRADE_COUNT;
			close();
		} else if (y >= 800) {
			close();
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				drop();
				if (proceeded) {
					if(!Main.GAME_START) {
						interrupt();
						break;
					}
					Thread.sleep(Main.SLEEP_TIME);
				} else {
					interrupt();
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public int getGradeType() {
		return gradeType;
	}

	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}

}
