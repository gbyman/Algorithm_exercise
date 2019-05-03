package algorithm_doublelinkedlist;
// ÀÌÁß ¿¬°á ¸®½ºÆ®ÀÇ ¼¿
public class CellDouble {
	
	CellDouble prev;	//ÀÌÀü ¼¿·ÎÀÇ ¸µÅ©
	CellDouble next;	//´ÙÀ½ ¼¿·ÎÀÇ ¸µÅ©
	Object data;	//ÀÌ ¼¿ÀÇ µ¥ÀÌÅÍ
	
//	¼¿À» »ý¼ºÇÑ´Ù
//	
//	@param aData ÀÌ ¼¿ÀÇ µ¥ÀÌÅÍ
	CellDouble(Object aData){
		
		prev = next = null;
		data = aData;
	}
}
