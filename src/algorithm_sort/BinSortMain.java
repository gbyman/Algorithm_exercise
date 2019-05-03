package algorithm_sort;
// 빈 소트 테스트 프로그램
public class BinSortMain {
	
//	빈 소트 과정을 보여준다
	public static void main(String[] args) {
		// 소트할 배열을 초기화 한다
		BinSortData[] array = new BinSortData[] {
				new BinSortData(13, "요소 0"),
				new BinSortData(24, "요소 1"),
				new BinSortData(15, "요소 2"),
				new BinSortData(5, "요소 3"),
				new BinSortData(98, "요소 4"),
				new BinSortData(44, "요소 5"),
				new BinSortData(35, "요소 6"),
				new BinSortData(96, "요소 7"),
				new BinSortData(82, "요소 8"),
				new BinSortData(73, "요소 9"),
		};
		
		//배열 array의 내용을 표시한다
		System.out.println("정렬하기 전");
		for(int i = 0; i < array.length; i++) {
			System.out.println("key = " + array[i].getKey() + " data = " + array[i].getData());
		}
		
		//배열 array를 빈 소트한다
		BinSort.sort(array);
		
		//배열 array의 내용을 표시한다
		System.out.println("정렬한 후");
		for(int i = 0; i < array.length; i++) {
			System.out.println("key = " + array[i].getKey() + " data = " + array[i].getData());
		}
	}
}
