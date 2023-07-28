impl Solution {
    pub fn next_greatest_letter(letters: Vec<char>, target: char) -> char {
        
        let mut l = 0;
        let mut r = letters.len();
        while l < r {
            let m = l + (r - l) / 2;
            if letters[m] <= target {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if l == letters.len() {
            letters[0]
        } else {
            letters[l]
        }
    }
}