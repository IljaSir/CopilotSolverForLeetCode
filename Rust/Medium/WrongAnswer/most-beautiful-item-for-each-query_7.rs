impl Solution {
    pub fn maximum_beauty(items: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut items = items;
        items.sort_unstable_by_key(|a| a[0]);
        let mut items = items.into_iter().map(|a| a[1]).collect::<Vec<i32>>();
        let mut prefix_sum = vec![0i64; items.len() + 1];
        for i in 0..items.len() {
            prefix_sum[i + 1] = prefix_sum[i] + items[i] as i64;
        }
        let mut res = vec![];
        for query in queries {
            let idx = items.binary_search(&query).unwrap_or_else(|x| x);
            if idx == 0 {
                res.push(0);
            } else {
                res.push((prefix_sum[idx] - prefix_sum[0]) as i32);
            }
        }
        res
    }
}