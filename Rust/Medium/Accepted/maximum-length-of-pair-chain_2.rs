impl Solution {
    pub fn find_longest_chain(pairs: Vec<Vec<i32>>) -> i32 {
        

        let mut pairs = pairs;
        pairs.sort_by(|a, b| a[1].cmp(&b[1]));
        let mut cur = i32::MIN;
        let mut ans = 0;
        for p in pairs {
            if p[0] > cur {
                cur = p[1];
                ans += 1;
            }
        }
        ans
    }
}