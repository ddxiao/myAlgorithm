package sorting_Basic;

import utils.SortTestHelper;

public class InsertionSort {
	
	private InsertionSort(){}
	
	/*
	 * 对于这个数组的插入排序
	 */
	public static void sort(Comparable[] arr){
		
		int n = arr.length;
		for(int i=0; i<n; i++){
			
			//写法1
			//寻找元素arr[i]合适的插入位置
//			for(int j=i; j>0; j--){
//				if(arr[j].compareTo(arr[j-1])<0)
//					swap(arr, j, j-1);
//				else
//					break;
//			}
			
			//写法2
//			for(int j=i;j>0 && arr[j].compareTo(arr[j-1]) < 0; j--){
//				swap(arr, j, j-1);
//			}
			
			//写法3
			Comparable e = arr[i];
			int j = i;
			for( ; j>0 && arr[j-1].compareTo(e)>0; j--){
				arr[j] = arr[j-1];
			arr[j] = e;
			}
			
		}
	}
	
	/*
	 * 对arr[l,r]的区间进行插入排序
	 */
	public static void sort(Comparable[] arr, int l, int r){
		
		for(int i = l + 1; i <= r; i++){
			Comparable e = arr[i];
			int j = i;
			for( ;j > l && arr[j-1].compareTo(e) > 0; j--){
				arr[j] = arr[j-1];
			}
			arr[j] = e;
			
		}
	}
	
	
	public static void swap(Object[] arr, int i, int j){
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
		
	}
	
	public static void main(String[] args){
		
		int N = 10000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
		SortTestHelper.testSort("sorting_Basic.InsertionSort", arr);
		
		return;
		
//		int N = 20;
//		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 20);
//		System.out.println("原始数组：");
//		for(int i=0;i<arr.length;i++){
//			System.out.print(arr[i]);
//			System.out.print(' ');
//		}
//		System.out.println();
//		
//		InsertionSort.sort(arr);
//		System.out.println("插入排序后的数组：");
//		for(int i=0;i<arr.length;i++){
//			System.out.print(arr[i]);
//			System.out.print(' ');
//		}
	}
	

}
