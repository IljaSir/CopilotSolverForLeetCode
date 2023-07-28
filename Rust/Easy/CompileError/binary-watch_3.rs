impl Solution {
    pub fn read_binary_watch(turned_on: i32) -> Vec<String> {
        
        let mut ans: Vec<String> = Vec::new();
        for h in 0..12 {
            for m in 0..60 {
                if (h as i32).count_ones() + (m as i32).count_ones() == turned_on {
                    ans.push(format!("{}:{:02}", h, m));
                }
            }
        }
        ans
    }
}