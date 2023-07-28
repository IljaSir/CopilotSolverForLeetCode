impl Solution {
    pub fn maximum_beauty(items: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut items = items;
        let mut queries = queries;
        items.sort_by(|a, b| a[0].cmp(&b[0]));
        queries.sort();
        let mut ans = vec![];
        let mut max = 0;
        let mut j = 0;
        for i in 0..queries.len() {
            while j < items.len() && items[j][0] <= queries[i] {
                max = max.max(items[j][1]);
                j += 1;
            }
            ans.push(max);
        }
        ans
    }
}