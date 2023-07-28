impl Solution {
    pub fn read_binary_watch(turned_on: i32) -> Vec<String> {
        
        let mut res = Vec::new();
        for i in 0..12 {
            for j in 0..60 {
                if i.count_ones() as i32 + j.count_ones() as i32 == turned_on {
                    res.push(format!("{}:{:02}", i, j));
                }
            }
        }
        res
    }
}