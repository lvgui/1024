package dome1024;

public class Config {
	public static int WIDTH = 450; //界面宽
	public static int HEIGHT = 450;	//界面高
	public static int CELL = 10;	//间隔
	public static int CELLWIDTH = 100; //图片宽高一致  100
	
	public static final int LEFT = 2;
	public static final int	UP = 4;
	public static final int	RIGHT = 3;
	public static final int	DOWN = 1;
	
	public static int[][] arr = { //二维数组
		{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}
	};
	
	public static void randFirse(){ //初始界面出现数字的两个位置
		int a = (int) Math.floor(Math.random() * 4);
		int b = (int) Math.floor(Math.random() * 4);
		int c = (int) Math.floor(Math.random() * 4);
		int d = (int) Math.floor(Math.random() * 4);
		arr[a][b] = (int) Math.floor(Math.random() * 2) + 1;
		arr[c][d] = (int) Math.floor(Math.random() * 2) + 1;
	}
}
