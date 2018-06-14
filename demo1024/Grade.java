package dome1024;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Grade implements Serializable {
	int score; //分数
	int nums; //步数	
	public Grade(int score, int nums) {
		this.score = score;
		this.nums = nums;
	}
	public boolean compare(Grade g){
		if(this.score > g.score){
			return true;
		}else if(this.score == g.score && this.nums >= g.nums){
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Grade [score=" + score + ", nums=" + nums + "]";
	}
	
}
