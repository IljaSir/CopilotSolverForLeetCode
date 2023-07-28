impl Solution {
    pub fn next_greatest_letter(letters: Vec<char>, target: char) -> char {
        
        let mut ans = letters[0];
        for i in 1..letters.len() {
            if letters[i] > target {
                ans = letters[i];
                break;
            }
        }
        ans
    }
}