impl Solution {
    pub fn maximum_beauty(items: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut items = items;
        items.sort_unstable_by(|a, b| a[0].cmp(&b[0]));
        let mut max_beauty = vec![0; items.len()];
        max_beauty[0] = items[0][1];
        for i in 1..items.len() {
            max_beauty[i] = max_beauty[i - 1].max(items[i][1]);
        }
        let mut ret = Vec::new();
        for query in queries {
            if let Some(pos) = items.binary_search_by(|a| a[0].cmp(&query)) {
                ret.push(max_beauty[pos]);
            } else {
                let pos = pos.max(1) - 1;
                ret.push(max_beauty[pos]);
            }
        }
        ret
    }
}