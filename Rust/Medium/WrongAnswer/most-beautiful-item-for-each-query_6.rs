impl Solution {
    pub fn maximum_beauty(items: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut items = items;
        items.sort_by_key(|x| x[0]);
        let mut ans = Vec::new();
        let mut cur = 0;
        for q in queries {
            while cur < items.len() && items[cur][0] <= q {
                cur += 1;
            }
            ans.push(items[..cur].iter().map(|x| x[1]).max().unwrap_or(0));
        }
        ans
    }
}