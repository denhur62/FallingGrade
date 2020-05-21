package test;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial") // FallingGrade ��� ���� ���� ���ϰ� �ϱ�
public class FallingGrade extends JFrame {
	
	// �ӽø޴��� ����
	private JLabel menuBar = new JLabel(new ImageIcon("C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽø޴���.png"));
	// �ӽø޴����� �������̹��� ����
	private ImageIcon menuBarExitBasicImage = new ImageIcon("C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽø޴�����.png");
	private ImageIcon menuBarExitMouseImage = new ImageIcon("C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽø޴����Ḷ�콺.png");

	// �ӽý��۹�ư �������̹��� ����
	private ImageIcon startButtonBasicImage = new ImageIcon( // �⺻ ���� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽý���.png");
	private ImageIcon startButtonMouseImage = new ImageIcon( // ���콺 �÷����� ��� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽý��۸��콺.png");

	// �ӽ������ư �������̹��� ����
	private ImageIcon exitButtonBasicImage = new ImageIcon( // �⺻ ���� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽ�����.png");
	private ImageIcon exitButtonMouseImage = new ImageIcon( // ���콺 �÷����� ��� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽ����Ḷ�콺.png");

	// �ӽð������� �������̹��� ����
	private ImageIcon gameTitleKoreanImage = new ImageIcon( // �⺻ ���� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽð��������ѱ�.png");
	private ImageIcon gameTitleEnglishImage = new ImageIcon( // ���콺 �÷����� ��� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽð������񿵾�.png");

	// ĳ���� ���ÿ䱸 �̹��� ����
	private Image selectCharacterImage = new ImageIcon("C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽ�ĳ���ͼ���.png").getImage();
	private boolean page2 = false;
	
	private Image backImage = new ImageIcon("C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽõ޹��.png").getImage();
	
	
	// ĳ���ͼ��� �������̹��� ����
	private ImageIcon kibokBasicImage = new ImageIcon( // �⺻ ���� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽñ⺹.png");
	private ImageIcon kibokMouseImage = new ImageIcon( // ���콺 �÷����� ��� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽñ⺹���콺.png");
	private ImageIcon junhyeonBasicImage = new ImageIcon( // �⺻ ���� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽ�����.png");
	private ImageIcon junhyeonMouseImage = new ImageIcon( // ���콺 �÷����� ��� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽ��������콺.png");
	private boolean isSelectedKibok = false;
	private boolean isSelectedJunhyeon = false;

	// ���̵� ���ÿ䱸 �̹��� ����
	private Image selectDifficultyImage = new ImageIcon("C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽó��̵�����.png").getImage();
	private boolean page3 = false;

	// ���̵����� �������̹��� ����
	private ImageIcon easyBasicImage = new ImageIcon( // �⺻ ���� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽý���.png");
	private ImageIcon easyMouseImage = new ImageIcon( // ���콺 �÷����� ��� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽý��򸶿콺.png");
	private ImageIcon normalBasicImage = new ImageIcon( // �⺻ ���� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽú���.png");
	private ImageIcon normalMouseImage = new ImageIcon( // ���콺 �÷����� ��� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽú��븶�콺.png");
	private ImageIcon hardBasicImage = new ImageIcon( // �⺻ ���� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽþ����.png");
	private ImageIcon hardMouseImage = new ImageIcon( // ���콺 �÷����� ��� �̹���
			"C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽþ���򸶿콺.png");

	// ����ĳ���� �̹��� ����
	private Image selectedPlayerImage; // ���� ���� �� ĳ���͸� ���� �� ��� �̹����� �־��ش�
	private boolean page4 = false;

	// �� �̹��� ����
	private Image bottom = new ImageIcon("C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽö�.png").getImage();

	// �ʿ��� ��ư ����
	private JButton menuBarExitButton = new JButton(menuBarExitBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton gameTitleButton = new JButton(gameTitleKoreanImage);
	private JButton selectKibokButton = new JButton(kibokBasicImage);
	private JButton selectJunhyeonButton = new JButton(junhyeonBasicImage);
	private JButton easyButton = new JButton(easyBasicImage);
	private JButton normalButton = new JButton(normalBasicImage);
	private JButton hardButton = new JButton(hardBasicImage);

	private int mouseX, mouseY;

	public FallingGrade() {
		setUndecorated(true); // �⺻ �޴��� ������
		setTitle("�ϴÿ��� ������ ��������"); // ������ �̸� ����
		setSize(Main.FRAME_WIDTH, Main.FRAME_HEIGHT); // ������ ũ�� ����
		setResizable(false); // ���� �� ������ ũ�� ���� �Ұ�
		setLocationRelativeTo(null); // ���� �ϸ� �������� ����� �� �߾ӿ� ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ ���� �� ��ü ���α׷� ����
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null); // ���� ��ġ�� �ٷ� �ְ� �ϴ� �뵵

		// �ӽ� �޴��������ư ����
		menuBarExitButton.setBounds(950, 0, 50, 50);
		menuBarExitButton.setBorderPainted(false);
		menuBarExitButton.setContentAreaFilled(false);
		menuBarExitButton.setFocusPainted(false);
		menuBarExitButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺 �ö����� �̹��� �ٲٱ�
			public void mouseEntered(MouseEvent mouse) {
				menuBarExitButton.setIcon(menuBarExitMouseImage);
				menuBarExitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ��ư���� �ö��� ��� �հ��� ��� Ŀ���� ����
			}

			@Override // ���콺 �������� �����·� ����
			public void mouseExited(MouseEvent mouse) {
				menuBarExitButton.setIcon(menuBarExitBasicImage);
				menuBarExitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // ������ ��� ���α׷� ����
			public void mousePressed(MouseEvent mouse) {
				System.exit(0);
			}
		});
		add(menuBarExitButton);

		// �ӽ� �޴��� ���� 
		menuBar.setBounds(0, 0, 1000, 50);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent mouse) {
				mouseX = mouse.getX();
				mouseY = mouse.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent mouse) { // ���콺�� �巡�� �� �� ���� x, y ��ǥ�� ������ JFrame ��ġ �ٲ��ֱ�
				int x = mouse.getXOnScreen();
				int y = mouse.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}

		});
		add(menuBar);

		// �ӽ� �������� ���� (�⺻ ���� : �ѱ�, ���콺 �ø� ���� : ����)
		gameTitleButton.setBounds(100, 100, 800, 350);
		gameTitleButton.setBorderPainted(false);
		gameTitleButton.setContentAreaFilled(false);
		gameTitleButton.setFocusPainted(false);
		gameTitleButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺 �ö����� ���� ����
			public void mouseEntered(MouseEvent mouse) {
				gameTitleButton.setIcon(gameTitleEnglishImage);
			}

			@Override // ���콺 �������� �ѱ� ����
			public void mouseExited(MouseEvent mouse) {
				gameTitleButton.setIcon(gameTitleKoreanImage);
			}
		});
		add(gameTitleButton);

		// �ӽ� ���۹�ư ����
		startButton.setBounds(100, 550, 300, 200);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺 �ö����� �̹��� �ٲٱ�
			public void mouseEntered(MouseEvent mouse) {
				startButton.setIcon(startButtonMouseImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ��ư���� �ö��� ��� �հ��� ��� Ŀ���� ����
			}

			@Override // ���콺 �������� �����·� ����
			public void mouseExited(MouseEvent mouse) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // ������ ��� ĳ���� ����â���� �̵�
			public void mousePressed(MouseEvent mouse) {

				// ĳ���� ����â���� �Ѿ��
				gameTitleButton.setVisible(false);
				startButton.setVisible(false);
				exitButton.setVisible(false);
				selectKibokButton.setVisible(true);
				selectJunhyeonButton.setVisible(true);
				page2 = true;
			}
		});
		add(startButton);

		// �ӽ� �����ư ����
		exitButton.setBounds(600, 550, 300, 200);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺 �ö����� �̹��� �ٲٱ�
			public void mouseEntered(MouseEvent mouse) {
				exitButton.setIcon(exitButtonMouseImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ��ư���� �ö��� ��� �հ��� ��� Ŀ���� ����
			}

			@Override // ���콺 �������� �����·� ����
			public void mouseExited(MouseEvent mouse) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // ������ ��� ���α׷� ����
			public void mousePressed(MouseEvent mouse) {
				System.exit(0);
			}
		});
		add(exitButton);

		// �ӽ� �⺹���ù�ư ����
		selectKibokButton.setVisible(false);
		selectKibokButton.setBounds(100, 450, 300, 400);
		selectKibokButton.setBorderPainted(false);
		selectKibokButton.setContentAreaFilled(false);
		selectKibokButton.setFocusPainted(false);
		selectKibokButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺 �ö����� �̹��� �ٲٱ�
			public void mouseEntered(MouseEvent mouse) {
				selectKibokButton.setIcon(kibokMouseImage);
				selectKibokButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ��ư���� �ö��� ��� �հ��� ��� Ŀ���� ����
			}

			@Override // ���콺 �������� �����·� ����
			public void mouseExited(MouseEvent mouse) {
				selectKibokButton.setIcon(kibokBasicImage);
				selectKibokButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // ������ ��� �⺹ĳ���� ����
			public void mousePressed(MouseEvent mouse) {
				selectKibokButton.setVisible(false);
				selectJunhyeonButton.setVisible(false);
				easyButton.setVisible(true);
				normalButton.setVisible(true);
				hardButton.setVisible(true);

				isSelectedKibok = true;
				page2 = false;
				page3 = true; // ���̵�����â �Ѿ��
			}
		});
		add(selectKibokButton);

		// �ӽ� �������ù�ư ����
		selectJunhyeonButton.setVisible(false);
		selectJunhyeonButton.setBounds(600, 450, 300, 400);
		selectJunhyeonButton.setBorderPainted(false);
		selectJunhyeonButton.setContentAreaFilled(false);
		selectJunhyeonButton.setFocusPainted(false);
		selectJunhyeonButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺 �ö����� �̹��� �ٲٱ�
			public void mouseEntered(MouseEvent mouse) {
				selectJunhyeonButton.setIcon(junhyeonMouseImage);
				selectJunhyeonButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ��ư���� �ö��� ��� �հ��� ��� Ŀ���� ����
			}

			@Override // ���콺 �������� �����·� ����
			public void mouseExited(MouseEvent mouse) {
				selectJunhyeonButton.setIcon(junhyeonBasicImage);
				selectJunhyeonButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // ������ ��� �⺹ĳ���� ����
			public void mousePressed(MouseEvent mouse) {
				selectKibokButton.setVisible(false);
				selectJunhyeonButton.setVisible(false);
				easyButton.setVisible(true);
				normalButton.setVisible(true);
				hardButton.setVisible(true);

				isSelectedJunhyeon = true;
				page2 = false;
				page3 = true; // ���̵�����â �Ѿ��
			}
		});
		add(selectJunhyeonButton);

		// �ӽ� �����̵���ư ����
		easyButton.setVisible(false);
		easyButton.setBounds(100, 550, 200, 150);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺 �ö����� �̹��� �ٲٱ�
			public void mouseEntered(MouseEvent mouse) {
				easyButton.setIcon(easyMouseImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ��ư���� �ö��� ��� �հ��� ��� Ŀ���� ����
			}

			@Override // ���콺 �������� �����·� ����
			public void mouseExited(MouseEvent mouse) {
				easyButton.setIcon(easyBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // ������ ��� �����̵� ����
			public void mousePressed(MouseEvent mouse) {
				page3 = false;
				page4 = true;
				gameStart("Easy");
			}
		});
		add(easyButton);

		// �ӽ� ���볭�̵���ư ����
		normalButton.setVisible(false);
		normalButton.setBounds(400, 550, 200, 150);
		normalButton.setBorderPainted(false);
		normalButton.setContentAreaFilled(false);
		normalButton.setFocusPainted(false);
		normalButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺 �ö����� �̹��� �ٲٱ�
			public void mouseEntered(MouseEvent mouse) {
				normalButton.setIcon(normalMouseImage);
				normalButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ��ư���� �ö��� ��� �հ��� ��� Ŀ���� ����
			}

			@Override // ���콺 �������� �����·� ����
			public void mouseExited(MouseEvent mouse) {
				normalButton.setIcon(normalBasicImage);
				normalButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // ������ ��� ���볭�̵� ����
			public void mousePressed(MouseEvent mouse) {
				page3 = false;
				page4 = true;
				gameStart("Normal");
			}
		});
		add(normalButton);

		// �ӽ� ������̵���ư ����
		hardButton.setVisible(false);
		hardButton.setBounds(700, 550, 200, 150);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺 �ö����� �̹��� �ٲٱ�
			public void mouseEntered(MouseEvent mouse) {
				hardButton.setIcon(hardMouseImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ��ư���� �ö��� ��� �հ��� ��� Ŀ���� ����
			}

			@Override // ���콺 �������� �����·� ����
			public void mouseExited(MouseEvent mouse) {
				hardButton.setIcon(hardBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // ������ ��� ������̵� ����
			public void mousePressed(MouseEvent mouse) {
				page3 = false;
				page4 = true;
				gameStart("Hard");
			}
		});
		add(hardButton);
	}

	public void frameDraw(Graphics g) { // frame �׸��� �Լ�
		g.drawImage(backImage, 0, 0, null); // repaint �Լ��� ���� �� ���� �� ����� ����
		if (page2) { // ĳ���� ���� â�ΰ��
			g.drawImage(selectCharacterImage, 100, 100, null);
		}
		if (page3) { // ���̵� ���� â�ΰ��
			g.drawImage(selectDifficultyImage, 100, 100, null);
		}
		if (page4) { // ���� ���� â�ΰ��
			g.drawImage(selectedPlayerImage, 425, 625, null);
			g.drawImage(bottom, 0, 775, null);
		}
		paintComponents(g); // �޴��� �׸���
		this.repaint();
	}

	public void gameStart(String difficulty) {
		if (isSelectedKibok) { // �⺹�� ���� �� ���
			selectedPlayerImage = new ImageIcon("C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽñ⺹ĳ����.png").getImage();
		}
		if (isSelectedJunhyeon) { // ������ ���� �� ���
			selectedPlayerImage = new ImageIcon("C:\\Users\\���⺹\\eclipse-workspace\\Falling Grade\\src\\Image\\�ӽ�����ĳ����.png").getImage();
		}
		easyButton.setVisible(false);
		normalButton.setVisible(false);
		hardButton.setVisible(false);

	}

}
