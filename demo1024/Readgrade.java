package dome1024;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Readgrade {
	ArrayList<Grade> list = new ArrayList<Grade>(); //记录
	ObjectInputStream ois;
	ObjectOutputStream oos;
	File files;
//	boolean newGrade = false; //是否打破记录
	public Readgrade(){
		File f = new File(this.getClass().getResource("").getPath()); 
//		System.out.println(f.getParent() + "\\files\\rank.txt");
		files = new File(f.getParent() + "\\files\\rank.txt");
		if(!files.exists()){
			System.out.println("文件错在");
			try {
				files.createNewFile();
			} catch (IOException e) {
				System.out.println("程序出错");
				e.printStackTrace();
			}
		}
	}
	public void readRank() throws Exception{ //读取文件记录
		try{
			list.clear();
//			System.out.println("ruge");
			if(files.length() != 0) {
				ois = new ObjectInputStream(new FileInputStream(files));
				list = (ArrayList<Grade>) ois.readObject();
			}		
		}finally{
			if(ois != null) {
				ois.close();
			}
		}
	}
	public String showRank(){
		try {
			readRank();
		} catch (Exception e) {
			System.out.println("程序出错了");
			e.printStackTrace();
		}
		String str = "";
		if(list.isEmpty()){
			str = "记录为空";
			return str;
		}else{
			str += "  名次\t步数\t分数\n\r";
			for(int i = 0;i < list.size();i++){
				if(list.get(i).nums != 0){
					str += "  " + (i + 1) + "\t" + list.get(i).score + "\t" + list.get(i).nums + "\n\r";
				}else if(i == 0){
					str = "记录为空";
					return str;
				}
		}
			return str;
		}
	}
	public boolean restRank() throws Exception{ //重置记录
		list.clear();
		for(int i = 0;i < 3;i++){
			list.add(new Grade(0,0));
		}
		oos = new ObjectOutputStream(new FileOutputStream(files));
		oos.writeObject(list);
		oos.close();
		return true;
	}
	public String writeRank(Grade g) throws Exception{ //写入数据
			readRank();
			String str = "";
			for(int i = list.size();i < 4;i++){
				list.add(new Grade(0,0));				
			}
			for(int i = 0;i < 3;i++){
				if(g.compare(list.get(i))){ //比较
					str += "恭喜你成功打破记录，位居排行帮第" + (i + 1) + "位\n\r";
					for(int j = 3;j > i;j--){
						if(j - 1 >= 0){
							list.set(j,list.get(j - 1));
						}
					}
					list.set(i, g);
					break;
				}
			}
			str += "本次成绩\n步数\t分数\n\r";
			str += g.score + "\t" + g.nums;
			list.remove(3);
			FileOutputStream fis = new FileOutputStream(files);
			oos = new ObjectOutputStream(fis);
			oos.writeObject(list);
			System.out.println("写入成功");
			oos.close();
			fis.close();
			return str;
//			System.out.println(list);				
	}
//	public static void main(String[] args) throws Exception {
//		Readgrade r = new Readgrade();
////		System.out.println(r.showRank());
////		if(!r.readRank()){
////			System.out.println("没有记录");
////		}
////		Grade g1 = new Grade(3,3);
////		r.list.add(g1);
//		r.writeRank(new Grade(3,3));
////		r.writeRank(new Grade(3,3));
////		r.writeRank(new Grade(3,3));
////		r.readRank();
//
//	}
}
