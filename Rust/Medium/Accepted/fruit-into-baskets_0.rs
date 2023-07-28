impl Solution {
    pub fn total_fruit(fruits: Vec<i32>) -> i32 {
        
        let mut l = 0;
        let mut r = 0;
        let mut m = std::collections::HashMap::new();
        let mut res = 0;
        while r < fruits.len() {
            *m.entry(fruits[r]).or_insert(0) += 1;
            while m.len() > 2 {
                *m.entry(fruits[l]).or_insert(0) -= 1;
                if m[&fruits[l]] == 0 {
                    m.remove(&fruits[l]);
                }
                l += 1;
            }
            res = res.max(r - l + 1);
            r += 1;
        }
        res as i32
    }
}