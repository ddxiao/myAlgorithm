package utils;

import java.lang.reflect.Method;
import java.lang.Class;

public class SortTestHelper {
	
	private SortTestHelper(){}
	
	//生成有n个元素的随机数组，每个元素的随机范围为[rangeL, rangeR]
	public static Integer[] generateRandomArray(int n, int rangeL, int rangeR){
		
		assert rangeL <= rangeR;
		
		Integer[] arr = new Integer[n];
		
		for(int i = 0; i < n;i++){
			arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
		}
		
		return arr;
	}
	
	// 生成近乎有序的数组
	public static Integer[] generateNearlyOrderedArray(int n,int swapTimes){
		Integer[] arr = new Integer[n];
		for(int i = 0; i < n; i++){
			arr[i] = new Integer(i);
		}
		
		for(int i = 0;i<swapTimes; i++){
			int a = (int) (Math.random()*n);
			int b = (int) (Math.random()*n);
			int t = arr[a];
			arr[a] = arr[b];
			arr[b] = t;
		}
		
		return arr;
	}
	
	
	
	//打印数组中的所有元素 
	public static void printArray(Object arr[]){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
	
	//判断数组中的元素是否有序
	public static boolean isSorted(Comparable[] arr){
		for(int i = 0; i < arr.length - 1; i++){
			if(arr[i].compareTo(arr[i+1]) > 0)
				return false;
		}
		
		return true;
	}
	
	//测试sortClassName所对应的排序算法 排序arr数组所得到结果的正确性和算法运行时间
	public static void testSort(String sortClassName, Comparable[] arr){
		//通过Java的反射机制，通过排序的类名，运行排序函数
		try{
			//通过sortClassName获得排序函数的class对象
			Class sortClass = Class.forName(sortClassName);
			//通过排序函数的class对象获得排序方法
			Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
			//排序参数只有一个，是可比较数组 arr
			Object[] params = new Object[]{arr};
			
			long startTime = System.currentTimeMillis();
			//调用排序函数
			sortMethod.invoke(null, params);
			long endTime = System.currentTimeMillis();
			
			assert isSorted(arr);
			
			System.out.println(sortClass.getSimpleName() + " : " + (endTime-startTime) + "ms");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
