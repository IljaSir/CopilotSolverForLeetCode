impl Solution {
    pub fn find_longest_chain(pairs: Vec<Vec<i32>>) -> i32 {
        

        let mut pairs = pairs;
        pairs.sort_unstable_by(|a, b| a[1].cmp(&b[1]));
        let mut ans = 0;
        let mut last = i32::MIN;
        for pair in pairs {
            if pair[0] > last {
                ans += 1;
                last = pair[1];
            }
        }
        ans
    }
}