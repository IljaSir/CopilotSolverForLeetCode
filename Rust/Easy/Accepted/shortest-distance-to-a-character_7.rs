impl Solution {
    pub fn shortest_to_char(s: String, c: char) -> Vec<i32> {
        
        let mut ans = vec![0; s.len()];
        let mut prev = -1_000_000;
        let mut next = s.find(c).unwrap() as i32;
        for i in 0..s.len() {
            if i as i32 == next {
                ans[i] = 0;
                prev = next;
                next = s[(i+1)..].find(c).map_or(1_000_000, |x| (x + i + 1) as i32);
            } else {
                ans[i] = std::cmp::min((i as i32 - prev).abs(), (i as i32 - next).abs());
            }
        }
        ans
    }
}