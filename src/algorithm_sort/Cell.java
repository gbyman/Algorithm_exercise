package algorithm_sort;
//¿¬°á ¸®½ºÆ®ÀÇ ¼¿
public class Cell {
	
	Cell next;//´ÙÀ½ ¼¿·ÎÀÇ ¸µÅ©
	Comparable data;//ÀÌ ¼¿ÀÇ µ¥ÀÌÅÍ
	
//	¼¿À» »ý¼ºÇÑ´Ù
//	
//	@param aData°¡ ¼¿ÀÇ µ¥ÀÌÅÍ
	Cell(Comparable aData){
		
		next = null;
		data = aData;
	}
}
