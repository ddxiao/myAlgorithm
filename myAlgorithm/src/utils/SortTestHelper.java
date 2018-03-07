package utils;

public class SortTestHelper {
	
	private SortTestHelper(){}
	
	//������n��Ԫ�ص�������飬ÿ��Ԫ�ص������ΧΪ[rangeL, rangeR]
	public static Integer[] generateRandomArray(int n, int rangeL, int rangeR){
		
		assert rangeL <= rangeR;
		
		Integer[] arr = new Integer[n];
		
		for(int i = 0; i < n;i++){
			arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
		}
		
		return arr;
	}
	
	//��ӡ�����е�����Ԫ��
	public static void printArray(Object arr[]){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
	
	//�ж������е�Ԫ���Ƿ�����
	public static boolean isSorted(Comparable[] arr){
		for(int i = 0; i < arr.length - 1; i++){
			if(arr[i].compareTo(arr[i+1]) > 0)
				return false;
		}
		
		return true;
	}
	
}
