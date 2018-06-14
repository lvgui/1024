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
	ArrayList<Grade> list = new ArrayList<Grade>(); //��¼
	ObjectInputStream ois;
	ObjectOutputStream oos;
	File files;
//	boolean newGrade = false; //�Ƿ���Ƽ�¼
	public Readgrade(){
		File f = new File(this.getClass().getResource("").getPath()); 
//		System.out.println(f.getParent() + "\\files\\rank.txt");
		files = new File(f.getParent() + "\\files\\rank.txt");
		if(!files.exists()){
			System.out.println("�ļ�����");
			try {
				files.createNewFile();
			} catch (IOException e) {
				System.out.println("�������");
				e.printStackTrace();
			}
		}
	}
	public void readRank() throws Exception{ //��ȡ�ļ���¼
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
			System.out.println("���������");
			e.printStackTrace();
		}
		String str = "";
		if(list.isEmpty()){
			str = "��¼Ϊ��";
			return str;
		}else{
			str += "  ����\t����\t����\n\r";
			for(int i = 0;i < list.size();i++){
				if(list.get(i).nums != 0){
					str += "  " + (i + 1) + "\t" + list.get(i).score + "\t" + list.get(i).nums + "\n\r";
				}else if(i == 0){
					str = "��¼Ϊ��";
					return str;
				}
		}
			return str;
		}
	}
	public boolean restRank() throws Exception{ //���ü�¼
		list.clear();
		for(int i = 0;i < 3;i++){
			list.add(new Grade(0,0));
		}
		oos = new ObjectOutputStream(new FileOutputStream(files));
		oos.writeObject(list);
		oos.close();
		return true;
	}
	public String writeRank(Grade g) throws Exception{ //д������
			readRank();
			String str = "";
			for(int i = list.size();i < 4;i++){
				list.add(new Grade(0,0));				
			}
			for(int i = 0;i < 3;i++){
				if(g.compare(list.get(i))){ //�Ƚ�
					str += "��ϲ��ɹ����Ƽ�¼��λ�����а��" + (i + 1) + "λ\n\r";
					for(int j = 3;j > i;j--){
						if(j - 1 >= 0){
							list.set(j,list.get(j - 1));
						}
					}
					list.set(i, g);
					break;
				}
			}
			str += "���γɼ�\n����\t����\n\r";
			str += g.score + "\t" + g.nums;
			list.remove(3);
			FileOutputStream fis = new FileOutputStream(files);
			oos = new ObjectOutputStream(fis);
			oos.writeObject(list);
			System.out.println("д��ɹ�");
			oos.close();
			fis.close();
			return str;
//			System.out.println(list);				
	}
//	public static void main(String[] args) throws Exception {
//		Readgrade r = new Readgrade();
////		System.out.println(r.showRank());
////		if(!r.readRank()){
////			System.out.println("û�м�¼");
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
