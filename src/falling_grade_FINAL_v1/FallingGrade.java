package falling_grade_FINAL_v1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial") // FallingGrade 노란 밑줄 생성 안하게 하기
public class FallingGrade extends JFrame {

	// 뒷 배경 생성
	
	private Image backGroundImage = new ImageIcon(".\\bin\\Image\\시작화면.png").getImage();

	// 임시메뉴바 생성
	private JLabel menuBar = new JLabel(new ImageIcon(".\\bin\\Image\\메뉴바.png"));
	// 임시메뉴종료 아이콘이미지 생성
	private ImageIcon menuBarExitBasicImage = new ImageIcon(".\\bin\\Image\\메뉴종료.png");
	private ImageIcon menuBarExitMouseImage = new ImageIcon(".\\bin\\Image\\메뉴종료 마우스.png");

	// 임시시작버튼 아이콘이미지 생성
	private ImageIcon startButtonBasicImage = new ImageIcon( // 기본 상태 이미지
			".\\bin\\Image\\START1.png");
	private ImageIcon startButtonMouseImage = new ImageIcon( // 마우스 올려졌을 경우 이미지
			".\\bin\\Image\\START.png");

	// 임시종료버튼 아이콘이미지 생성
	private ImageIcon exitButtonBasicImage = new ImageIcon( // 기본 상태 이미지
			".\\bin\\Image\\END.png");
	private ImageIcon exitButtonMouseImage = new ImageIcon( // 마우스 올려졌을 경우 이미지
			".\\bin\\Image\\END1.png");

	// 임시게임제목 아이콘이미지 생성
	//private ImageIcon gameTitleKoreanImage = new ImageIcon( // 기본 상태 이미지
			//".\\bin\\Image\\게임제목한글.png");
	//private ImageIcon gameTitleEnglishImage = new ImageIcon( // 마우스 올려졌을 경우 이미지
			//".\\bin\\Image\\영어제목.png");

	// 캐릭터 선택요구 이미지 생성
	//private Image selectCharacterImage = new ImageIcon(".\\bin\\Image\\캐릭터선택.png").getImage();
	
	private Image selectCharacterImage = new ImageIcon(".\\bin\\Image\\캐릭터 선택화면.png").getImage();
	private boolean page2 = false;

	// 캐릭터선택 아이콘이미지 생성
	private ImageIcon kibokBasicImage = new ImageIcon( // 기본 상태 이미지
			".\\bin\\Image\\기복몸통.png");
	private ImageIcon kibokMouseImage = new ImageIcon( // 마우스 올려졌을 경우 이미지
			".\\bin\\Image\\기복몸통1.png");
	private ImageIcon junhyeonBasicImage = new ImageIcon( // 기본 상태 이미지
			".\\bin\\Image\\준현몸통.png");
	private ImageIcon junhyeonMouseImage = new ImageIcon( // 마우스 올려졌을 경우 이미지
			".\\bin\\Image\\준현몸통1.png");

	// 난이도 선택요구 이미지 생성
	private Image selectDifficultyImage = new ImageIcon(".\\bin\\Image\\난이도선택 화면.png").getImage();
	private boolean page3 = false;

	// 난이도선택 아이콘이미지 생성
	private ImageIcon easyBasicImage = new ImageIcon( // 기본 상태 이미지
			".\\bin\\Image\\EASY.png");
	private ImageIcon easyMouseImage = new ImageIcon( // 마우스 올려졌을 경우 이미지
			".\\bin\\Image\\EASY1.png");
	private ImageIcon normalBasicImage = new ImageIcon( // 기본 상태 이미지
			".\\bin\\Image\\NORMAL.png");
	private ImageIcon normalMouseImage = new ImageIcon( // 마우스 올려졌을 경우 이미지
			".\\bin\\Image\\NORMAL1.png");
	private ImageIcon hardBasicImage = new ImageIcon( // 기본 상태 이미지
			".\\bin\\Image\\HARD.png");
	private ImageIcon hardMouseImage = new ImageIcon( // 마우스 올려졌을 경우 이미지
			".\\bin\\Image\\HARD1.png");

	// 선택캐릭터 이미지 생성
	public static boolean page4 = false;
	//게임 화면창
	private Image gameImage = new ImageIcon(".\\bin\\Image\\게임화면.png").getImage();
	// 게임 결과 창 생성
	//3점이상일떄랑 3점이하 일떄 넣기 
	private Image resultIamge = new ImageIcon(".\\bin\\Image\\3이상승리화면.png").getImage();
	public static boolean page5 = false;
	private Image resultIamge1 = new ImageIcon(".\\bin\\Image\\3점이하승리화면.png").getImage();
	
	private Image gameoverImage = new ImageIcon(".\\bin\\Image\\게임종료화면.png").getImage();
	public static boolean gameoverPage = false;

	// 필요한 버튼 생성
	private JButton menuBarExitButton = new JButton(menuBarExitBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton exitButton = new JButton(exitButtonBasicImage);
	//private JButton gameTitleButton = new JButton(gameTitleKoreanImage);
	private JButton selectKibokButton = new JButton(kibokBasicImage);
	private JButton selectJunhyeonButton = new JButton(junhyeonBasicImage);
	private JButton easyButton = new JButton(easyBasicImage);
	private JButton normalButton = new JButton(normalBasicImage);
	private JButton hardButton = new JButton(hardBasicImage);
	

	private int mouseX, mouseY;

	public static Game game;
	public static Player player = new Player();

	public FallingGrade() {
		setUndecorated(true); // 기본 메뉴바 가리기
		setTitle("하늘에서 학점이 떨어져요"); // 프레임 이름 설정
		setSize(Main.FRAME_WIDTH, Main.FRAME_HEIGHT); // 프레임 크기 설정
		setResizable(false); // 실행 후 프레임 크기 조절 불가
		setLocationRelativeTo(null); // 실행 하면 프레임이 모니터 정 중앙에 출력
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 시 전체 프로그램 종료
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null); // 삽입 위치에 바로 넣게 하는 용도
		addKeyListener(new KeyListener());
		Music intro= new Music("전전세세.mp3",true);
		intro.start();
		// 임시 메뉴바종료버튼 삽입
		menuBarExitButton.setBounds(950, 0, 50, 50);
		menuBarExitButton.setBorderPainted(false);
		menuBarExitButton.setContentAreaFilled(false);
		menuBarExitButton.setFocusPainted(false);
		menuBarExitButton.addMouseListener(new MouseAdapter() {
			@Override // 마우스 올라갔을때 이미지 바꾸기
			public void mouseEntered(MouseEvent mouse) {
				menuBarExitButton.setIcon(menuBarExitMouseImage);
				Music click = new Music("click.mp3",false);
				click.start();
				menuBarExitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 버튼위에 올라갔을 경우 손가락 모양 커서로 변경
			}

			@Override // 마우스 나왔을때 원상태로 복귀
			public void mouseExited(MouseEvent mouse) {
			
				menuBarExitButton.setIcon(menuBarExitBasicImage);
				menuBarExitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override // 눌렀을 경우 프로그램 종료
			public void mousePressed(MouseEvent mouse) {
				System.exit(0);
			}
		});
		add(menuBarExitButton);

		// 임시 메뉴바 삽입 
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
			public void mouseDragged(MouseEvent mouse) { // 마우스를 드래그 할 때 마다 x, y 좌표를 가져와 JFrame 위치 바꿔주기
				int x = mouse.getXOnScreen();
				int y = mouse.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}

		});
		add(menuBar);

		// 임시 게임제목 삽입 (기본 상태 : 한글, 마우스 올린 상태 : 영어)
		/*
		 * gameTitleButton.setBounds(100, 100, 800, 350);
		 * gameTitleButton.setBorderPainted(false);
		 * gameTitleButton.setContentAreaFilled(false);
		 * gameTitleButton.setFocusPainted(false); gameTitleButton.addMouseListener(new
		 * MouseAdapter() {
		 * 
		 * @Override // 마우스 올라갔을때 영어 제목 public void mouseEntered(MouseEvent mouse) {
		 * 
		 * gameTitleButton.setIcon(gameTitleEnglishImage); }
		 * 
		 * @Override // 마우스 나왔을때 한글 제목 public void mouseExited(MouseEvent mouse) {
		 * gameTitleButton.setIcon(gameTitleKoreanImage); } }); add(gameTitleButton);
		 */

		//  시작버튼 삽입
		startButton.setBounds(100, 550, 250, 150);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override // 마우스 올라갔을때 이미지 바꾸기
			public void mouseEntered(MouseEvent mouse) {
				startButton.setIcon(startButtonMouseImage);
				Music click = new Music("click.mp3",false);
				click.start();
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 버튼위에 올라갔을 경우 손가락 모양 커서로 변경
			}

			@Override // 마우스 나왔을때 원상태로 복귀
			public void mouseExited(MouseEvent mouse) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 눌렀을 경우 캐릭터 선택창으로 이동
			public void mousePressed(MouseEvent mouse) {
				
				// 캐릭터 선택창으로 넘어가기
				//gameTitleButton.setVisible(false);
				startButton.setVisible(false);
				exitButton.setVisible(false);
				selectKibokButton.setVisible(true);
				selectJunhyeonButton.setVisible(true);
				page2 = true;
				
			}
		});
		add(startButton);

		// 임시 종료버튼 삽입
		exitButton.setBounds(600, 550, 250, 150);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override // 마우스 올라갔을때 이미지 바꾸기
			public void mouseEntered(MouseEvent mouse) {
				Music click = new Music("click.mp3",false);
				click.start();
				exitButton.setIcon(exitButtonMouseImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 버튼위에 올라갔을 경우 손가락 모양 커서로 변경
			}

			@Override // 마우스 나왔을때 원상태로 복귀
			public void mouseExited(MouseEvent mouse) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 눌렀을 경우 프로그램 종료
			public void mousePressed(MouseEvent mouse) {
				
				System.exit(0);
			}
		});
		add(exitButton);

		// 임시 기복선택버튼 삽입
		selectKibokButton.setVisible(false);
		selectKibokButton.setBounds(100, 450, 200, 400);
		selectKibokButton.setBorderPainted(false);
		selectKibokButton.setContentAreaFilled(false);
		selectKibokButton.setFocusPainted(false);
		selectKibokButton.addMouseListener(new MouseAdapter() {
			@Override // 마우스 올라갔을때 이미지 바꾸기
			public void mouseEntered(MouseEvent mouse) {
				Music WHO = new Music("who.mp3",false);
				WHO.start();
				selectKibokButton.setIcon(kibokMouseImage);
				selectKibokButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 버튼위에 올라갔을 경우 손가락 모양 커서로 변경
			}

			@Override // 마우스 나왔을때 원상태로 복귀
			public void mouseExited(MouseEvent mouse) {
				selectKibokButton.setIcon(kibokBasicImage);
				selectKibokButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 눌렀을 경우 기복캐릭터 선택
			public void mousePressed(MouseEvent mouse) {
				
				selectKibokButton.setVisible(false);
				selectJunhyeonButton.setVisible(false);
				easyButton.setVisible(true);
				normalButton.setVisible(true);
				hardButton.setVisible(true);

				player.selectedPlayerImage = new ImageIcon(".\\bin\\Image\\150기복.png").getImage();
				page2 = false;
				page3 = true; // 난이도선택창 넘어가기
			}
		});
		add(selectKibokButton);

		// 임시 준현선택버튼 삽입
		selectJunhyeonButton.setVisible(false);
		selectJunhyeonButton.setBounds(600, 450, 200, 400);
		selectJunhyeonButton.setBorderPainted(false);
		selectJunhyeonButton.setContentAreaFilled(false);
		selectJunhyeonButton.setFocusPainted(false);
		selectJunhyeonButton.addMouseListener(new MouseAdapter() {
			@Override // 마우스 올라갔을때 이미지 바꾸기
			public void mouseEntered(MouseEvent mouse) {
				Music you = new Music("you.mp3",false);
				you.start();
				selectJunhyeonButton.setIcon(junhyeonMouseImage);
				selectJunhyeonButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 버튼위에 올라갔을 경우 손가락 모양 커서로 변경
			}

			@Override // 마우스 나왔을때 원상태로 복귀
			public void mouseExited(MouseEvent mouse) {
				selectJunhyeonButton.setIcon(junhyeonBasicImage);
				selectJunhyeonButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 눌렀을 경우 기복캐릭터 선택
			public void mousePressed(MouseEvent mouse) {
				
				selectKibokButton.setVisible(false);
				selectJunhyeonButton.setVisible(false);
				easyButton.setVisible(true);
				normalButton.setVisible(true);
				hardButton.setVisible(true);

				player.selectedPlayerImage = new ImageIcon(".\\bin\\Image\\150준현.png").getImage();
				page2 = false;
				page3 = true; // 난이도선택창 넘어가기

			}
		});
		add(selectJunhyeonButton);

		// 임시 쉬움난이도버튼 삽입
		easyButton.setVisible(false);
		easyButton.setBounds(100, 550, 250, 150);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override // 마우스 올라갔을때 이미지 바꾸기
			public void mouseEntered(MouseEvent mouse) {
				Music click = new Music("click.mp3",false);
				click.start();
				easyButton.setIcon(easyMouseImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 버튼위에 올라갔을 경우 손가락 모양 커서로 변경
			}

			@Override // 마우스 나왔을때 원상태로 복귀
			public void mouseExited(MouseEvent mouse) {
				easyButton.setIcon(easyBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 눌렀을 경우 쉬움난이도 선택
			public void mousePressed(MouseEvent mouse) {
				
				page3 = false;
				page4 = true;
				easyButton.setVisible(false);
				normalButton.setVisible(false);
				hardButton.setVisible(false);

				game = new Game("EASY");
				game.start();
				startTimer();
			}
		});
		add(easyButton);

		// 임시 보통난이도버튼 삽입
		normalButton.setVisible(false);
		normalButton.setBounds(400, 550, 250, 150);
		normalButton.setBorderPainted(false);
		normalButton.setContentAreaFilled(false);
		normalButton.setFocusPainted(false);
		normalButton.addMouseListener(new MouseAdapter() {
			@Override // 마우스 올라갔을때 이미지 바꾸기
			public void mouseEntered(MouseEvent mouse) {
				Music click = new Music("click.mp3",false);
				click.start();
				normalButton.setIcon(normalMouseImage);
				normalButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 버튼위에 올라갔을 경우 손가락 모양 커서로 변경
			}

			@Override // 마우스 나왔을때 원상태로 복귀
			public void mouseExited(MouseEvent mouse) {
				normalButton.setIcon(normalBasicImage);
				normalButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 눌렀을 경우 보통난이도 선택
			public void mousePressed(MouseEvent mouse) {
				
				page3 = false;
				page4 = true;
				easyButton.setVisible(false);
				normalButton.setVisible(false);
				hardButton.setVisible(false);

				game = new Game("NORMAL");
				game.start();
				startTimer();
			}
		});
		add(normalButton);

		// 임시 어려움난이도버튼 삽입
		hardButton.setVisible(false);
		hardButton.setBounds(700, 550, 250, 150);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override // 마우스 올라갔을때 이미지 바꾸기
			public void mouseEntered(MouseEvent mouse) {
				Music click = new Music("click.mp3",false);
				click.start();
				hardButton.setIcon(hardMouseImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 버튼위에 올라갔을 경우 손가락 모양 커서로 변경
			}

			@Override // 마우스 나왔을때 원상태로 복귀
			public void mouseExited(MouseEvent mouse) {
				hardButton.setIcon(hardBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 눌렀을 경우 어려움난이도 선택
			public void mousePressed(MouseEvent mouse) {
				page3 = false;
				page4 = true;
				easyButton.setVisible(false);
				normalButton.setVisible(false);
				hardButton.setVisible(false);

				game = new Game("HARD");
				game.start();
				startTimer();
			}
		});
		add(hardButton);
	}

	public void paint(Graphics g) {
		screenDraw(g);
	}

	public void screenDraw(Graphics g) { // frame 그리기 함수
		g.drawImage(backGroundImage, 0, 0, null);
		
		  if (page2) { // 캐릭터 선택 창인경우
			  g.drawImage(selectCharacterImage, 0, 0,null);
			  
			  }
		  if (page3) { // 난이도 선택 창인경우 
			  g.drawImage(selectDifficultyImage, 0,0, null);
			  
			  }
		 
		if (page4) { // 게임 실행 창인경우
			g.drawImage(gameImage,0,0,null);
			player.screenDraw(g);
			game.screenDraw(g);
			
		}
		if (page5) { // 게임 결과 창인경우
			if(Main.SCORE>=3.0)
			{
				g.drawImage(resultIamge, 0, 0, null);
				g.setColor(Color.black);
				g.setFont(new Font("Arial", Font.BOLD, 100));
				g.drawString(String.format("%.2f", Main.SCORE), 200, 680);
			}
			else
			{
				g.drawImage(resultIamge1, 0, 0, null);
				g.setColor(Color.black);
				g.setFont(new Font("Arial", Font.BOLD, 100));
				g.drawString(String.format("%.2f", Main.SCORE), 200, 680);
			}
		
		}
		
		
		if (gameoverPage) { // 게임오버 창 인경우
			
			g.drawImage(gameoverImage, 0, 0, null);
		}
		paintComponents(g); // 메뉴바 그리기
		this.repaint();
	}

	public void startTimer() {
		Timer m_timer = new Timer();
		TimerTask m_task = new TimerTask() {
			@Override
			public void run() {
				Main.TIME -= 1;
				if (Main.TIME == 0) {
					m_timer.cancel();
					Main.GAME_START = false;
					page4 = false;
					page5 = true;
				}
			}
		};
		m_timer.schedule(m_task, 0, 1000);
	}
	 
}
