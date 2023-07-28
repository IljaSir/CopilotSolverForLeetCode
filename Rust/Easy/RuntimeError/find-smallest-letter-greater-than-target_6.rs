impl Solution {
    pub fn next_greatest_letter(letters: Vec<char>, target: char) -> char {
        
        let mut l = 0;
        let mut r = letters.len() - 1;
        let mut ans = letters[0];
        while l <= r {
            let m = (l + r) / 2;
            if letters[m] <= target {
                l = m + 1;
            } else {
                ans = letters[m];
                r = m - 1;
            }
        }
        ans
    }
}