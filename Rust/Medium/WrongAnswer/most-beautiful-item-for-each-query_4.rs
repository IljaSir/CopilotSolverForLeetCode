impl Solution {
    pub fn maximum_beauty(items: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut items = items;
        let mut queries = queries;
        items.sort_by_key(|v| v[0]);
        queries.sort_by_key(|v| *v);
        let mut ans = vec![0; queries.len()];
        let mut i = 0;
        let mut j = 0;
        let mut max = 0;
        while i < items.len() {
            max = max.max(items[i][1]);
            while j < queries.len() && queries[j] < items[i][0] {
                ans[j] = max;
                j += 1;
            }
            i += 1;
        }
        while j < queries.len() {
            ans[j] = max;
            j += 1;
        }
        ans
    }
}