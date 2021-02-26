
import java.util.Arrays;

public class SortingComparison {

	public static void main(String[] args) {
		long start1;
		long start2;
		long end1;
		long end2;
		long time1;
		long time2;
		// TODO Auto-generated method stub
		for(int i=1000;i<=25000;i+=1000) {//size of the array
			int[]a=new int[i];
			int[]b=new int[i];
			for(int j=0;j<i;j++) {
				int k=(int)(Math.random()*5000);
				a[j]=k;
				b[j]=k;
			}
//			System.out.println("The original data in a is"+Arrays.toString(a));
			start1=System.currentTimeMillis();
			SelectionSort(a);
			end1=System.currentTimeMillis();
			time1=end1-start1;
//			System.out.println("The sorted data in a is"+Arrays.toString(a));

//			System.out.println("The original data in b is"+Arrays.toString(b));
			start2=System.currentTimeMillis();
			heapSort(b);
			end2=System.currentTimeMillis();
			time2=end2-start2;
//			System.out.println("The sorted data in b is"+Arrays.toString(b));
			System.out.println(i+" "+time1+" "+time2);
		}
	}
	public static void SelectionSort(int[]arr) {
		for(int i=0;i<arr.length;i++) {
			int min=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
			}
			if(min!=i) {
				int temp=arr[i];
				arr[i]=arr[min];
				arr[min]=temp;
			}
		}
	}
	public static void heapSort(int[]arr) {
		heapInsert(arr);
		int size=arr.length;
		while(size>0) {
			swap(arr,0,size-1);
			size--;
			heapify(arr,0,size);
		}
	}
	public static void heapInsert(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int currentIndex=i;
			int fatherIndex=(currentIndex-1)/2;
			while(arr[currentIndex]>arr[fatherIndex]) {
				swap(arr,currentIndex,fatherIndex);
				currentIndex=fatherIndex;
				fatherIndex=(currentIndex-1)/2;
			}
		}
	}
	public static void swap(int[]arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void heapify(int[]arr,int index,int size) {
		int left=2*index+1;
		int right=2*index+2;
		while(left<size) {
			int largestIndex;
			if(arr[left]<arr[right]&&right<size) {
				largestIndex=right;
			}
			else {
				largestIndex=left;
			}
			if(arr[index]>arr[largestIndex]) {
				largestIndex=index;
			}
			if(index==largestIndex) {
				break;
			}
			swap(arr,largestIndex,index);
			index=largestIndex;
			left=2*index+1;
			right=2*index+2;
		}
	}
}
lll
