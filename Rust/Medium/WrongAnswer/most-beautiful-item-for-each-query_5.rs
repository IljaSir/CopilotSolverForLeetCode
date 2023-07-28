impl Solution {
    pub fn maximum_beauty(items: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut items = items;
        items.sort_by(|a, b| a[0].cmp(&b[0]));
        let mut result = Vec::new();
        let mut max_beauty = 0;
        let mut index = 0;
        for query in queries {
            while index < items.len() && items[index][0] <= query {
                max_beauty = max_beauty.max(items[index][1]);
                index += 1;
            }
            result.push(max_beauty);
        }
        result
    }
}