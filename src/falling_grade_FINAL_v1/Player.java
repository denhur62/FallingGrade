package falling_grade_FINAL_v1;

import java.awt.Graphics;
import java.awt.Image;

public class Player {
	public Image selectedPlayerImage;
	public int x = 425;
	

	public int getX() {
		return x;
	}


	public void screenDraw(Graphics g) {
		g.drawImage(selectedPlayerImage, x, 625, null);
	}
	
	public void pressRight() {
		if (x <= 860) { // 오른쪽 창 바깥으로 벗어나지 않는 조건
			x = x + 20;
		}

	}

	public void pressLeft() {
		if (x >= 5) { // 왼쪽 창 바깥으로 벗어나지 않는 조건
			x = x - 20;
		}
	}

}
