package arraydemo1;

import java.util.Random;

/**
 * 0-99这100个数字,放在数组中,
 * 再增加一个数字,放进去
 * 打乱数组
 * 找出这个重复的数字 
 * 
 * */
public class Test {

	public static void main(String[] args) {
		//定义一个数组
		int[] arr = new int[101];
		//0-99这100个数字,放在数组中
		for(int i=0; i<arr.length; i++) {
			arr[i]=i;
		}
		//再增加一个数字,放进去
		arr[100]=88;
		//打印数组看一下效果
		showArr(arr);
		System.out.println("---------------------------------");
		//打乱数组,random取前不取后
		for(int k=0;k<1000;k++){
			Random r = new Random();
			int i = r.nextInt(101);
			int j = r.nextInt(101);
			int temp =arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		showArr(arr);
		System.out.println("---------------------------------");
		fun1(arr);
		System.out.println("---------------------------------");
		fun2(arr);
		System.out.println("---------------------------------");
		fun3(arr);
		
	}

	//方式三:用arr[0]的元素和剩余数组所有的元素进行异或,
	//再和0-99异或,得到的就是重复的元素,A^B^B=A
	private static void fun3(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			arr[0] ^=arr[i];
		}
		for(int i=0; i<100; i++) {
			arr[0] ^=i;
		}
		System.out.println("重复的元素是:"+arr[0]);
	}

	//方式二:求所有元素的和,减去0-99的和,得到的就是重复的那个
	//如果数组元素数值比较大的时候,可能会超出int的范围
	private static void fun2(int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum +=arr[i];
		}	
		for(int j=0; j<100; j++) {
			sum -= j;
		}
		System.out.println("重复的元素是:"+sum);
	}

	//方式一:初学者的想法(效率低)
	//每一个元素和它后面的所有元素作比较
	private static void fun1(int[] arr) {
		flag:for(int i=0; i<arr.length; i++) {
			for(int j=i+1;j<arr.length; j++) {
				if(arr[i]==arr[j]) {
					System.out.println("重复的元素是:"+arr[i]);
					break flag;//break只能跳出一层循环,所以要用带标记的break
				}
			}
		}
	}

	private static void showArr(int[] arr) {
		int count = 0;
		for(int j=0; j<arr.length; j++){
			System.out.print(arr[j]+"\t");
			if(++count%10==0) {
				System.out.println();
			}
		}
		System.out.println();
	}

}
