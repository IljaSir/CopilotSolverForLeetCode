impl Solution {
    pub fn distribute_cookies(cookies: Vec<i32>, k: i32) -> i32 {
        
        let mut cookies = cookies;
        cookies.sort();
        let mut unfairness = i32::MAX;
        let mut i = 0;
        while i + k as usize <= cookies.len() {
            let mut j = i + 1;
            while j + k as usize - 1 <= cookies.len() {
                let mut unfairness1 = 0;
                for x in i..j {
                    unfairness1 += cookies[x];
                }
                let mut unfairness2 = 0;
                for x in j..j + k as usize {
                    unfairness2 += cookies[x];
                }
                unfairness = unfairness.min((unfairness1 - unfairness2).abs());
                j += 1;
            }
            i += 1;
        }
        unfairness
    }
}