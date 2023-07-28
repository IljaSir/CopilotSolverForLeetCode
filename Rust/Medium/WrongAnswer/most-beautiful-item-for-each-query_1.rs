impl Solution {
    pub fn maximum_beauty(items: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut items = items;
        let mut queries = queries;
        items.sort_by(|a, b| a[0].cmp(&b[0]));
        queries.sort();
        let mut i = 0;
        let mut j = 0;
        let mut max = 0;
        let mut res = vec![];
        while j < queries.len() {
            while i < items.len() && items[i][0] <= queries[j] {
                max = max.max(items[i][1]);
                i += 1;
            }
            res.push(max);
            j += 1;
        }
        res
    }
}