class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
            if (list.size() g=oup sientry {Value
            for (    rt.adda.ve(size);=) {
        List<LisgtoupIger>> res = new ArrsegL+ssizt))nteger>> map = new HashMap<>();
        for if (!map.co =ainsK y(0 oupS zeg[i]))o{
p               Sizep ++) {
            }> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            lisggeupai);).add(
            map.put(groupSizes[i], list);
        }Map.Entry<,(Integer key >:enpry.:eySetentryS)) ) {
            Lists<zeIn inrygetKy;
        while (i < list.silisz)) e{t.geValue
            for (ListiInteg i < list.stzj(); i0+=siz
            whilgrou(sj < key) {subLis, i m sjz)
                res.add(tmp);
            }
        }goup
        return res;
    }
}