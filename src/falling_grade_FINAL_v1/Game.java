package falling_grade_FINAL_v1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Game extends Thread {
	//Thread : 하나의 프로그램에서 돌아가는 작은 프로그램 개념

	// 땅 이미지 생성
	private Image bottom = new ImageIcon(".\\bin\\Image\\땅.png").getImage();

	private String difficulty;

	ArrayList<Grade> gradeList = new ArrayList<Grade>();
	LocalDateTime now = LocalDateTime.now();

	public Game(String difficulty) {
		this.difficulty = difficulty;
	}

	public void screenDraw(Graphics g) {

		for (int i = 0; i < gradeList.size(); i++) {
			Grade grade = gradeList.get(i);
			if (!grade.isProceeded()) {
				gradeList.remove(i);
				i--;
			} else {
				grade.screenDraw(g);
			}
		}
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(difficulty, 0, 890);
		g.drawString("SCORE : " + String.format("%.2f", Main.SCORE), 200, 890);

		g.setColor(Color.red);
		g.drawString("F CONUT : " + Main.FCOUNT, 500, 890);

		g.setColor(Color.black);
		g.drawString("TIME : " + Main.TIME, 800, 890);
		g.drawImage(bottom, 0, 775, null);

	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	Random generator = new Random();

	@Override
	public void run() {
		while (true) {
			if (Main.GAME_START) {
				if (this.difficulty.equals("EASY")) {
					try {
						Thread.sleep(800); // 0.8초마다
						Grade grade = new Grade(generator.nextInt(5));
						grade.start();
						gradeList.add(grade);
					} catch (InterruptedException e) {
						System.err.println(e.getMessage());
					}
				} else if (this.difficulty.equals("NORMAL")) {
					try {
						Thread.sleep(500); // 0.5초마다
						Grade grade = new Grade(generator.nextInt(5));
						grade.start();
						gradeList.add(grade);
					} catch (InterruptedException e) {
						System.err.println(e.getMessage());
					}
				} else {
					try {
						Thread.sleep(300); // 0.3초마다
						Grade grade = new Grade(generator.nextInt(5));
						//grade.start();
						//gradeList.add(grade);
					} catch (InterruptedException e) {
						System.err.println(e.getMessage());
					}
				}
			}
			else {
				interrupt();
				break;
			}
		}
	}
}
