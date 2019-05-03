package algorithm_sort;
// 기수 소트 메인 프로그램
public class RadixSortMain {
	
	// 기수 소트 과정을 보여준다
	public static void main(String[] args) {
		
		// 소트할 배열을 초기화한다
		RadixSortData[] array = new RadixSortData[] {
			new RadixSortData(0x2f38, "요소 0"),
			new RadixSortData(0x2fb7, "요소 1"),
			new RadixSortData(0x9328, "요소 2"),
			new RadixSortData(0xa400, "요소 3"),
			new RadixSortData(0x000f, "요소 4"),
			new RadixSortData(0x0002, "요소 5"),
			new RadixSortData(0x0844, "요소 6"),
			new RadixSortData(0xef85, "요소 7"),
			new RadixSortData(0x289a, "요소 8"),
			new RadixSortData(0x2f30, "요소 9"),
		};
		
		// 배열 array의 내용을 표시한다
		System.out.println("정렬하기 전");
		RadixSort.dumpArray(array);
		
		// 배열 array를 기수 소트한다
		RadixSort.sort(array);
	}
}
