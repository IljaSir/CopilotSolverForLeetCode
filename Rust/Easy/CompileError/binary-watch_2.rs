impl Solution {
    pub fn read_binary_watch(turned_on: i32) -> Vec<String> {
        
        let mut result = vec![];
        for i in 0..12 {
            for j in 0..60 {
                if i.count_ones() + j.count_ones() == turned_on as u32 {
                    result.push(format!("{}:{:02}", i, j));
                }
            }
        }
        result
    }
}