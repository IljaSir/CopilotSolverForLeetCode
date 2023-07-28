impl Solution {
    pub fn next_greatest_letter(letters: Vec<char>, target: char) -> char {
        
        let mut l = 0;
        let mut r = letters.len() - 1;
        while l <= r {
            let m = l + (r - l) / 2;
            if letters[m] > target {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if l < letters.len() {
            letters[l]
        } else {
            letters[0]
        }
    }
}