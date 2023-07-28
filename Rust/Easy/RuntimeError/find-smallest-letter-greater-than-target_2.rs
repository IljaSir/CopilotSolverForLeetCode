impl Solution {
    pub fn next_greatest_letter(letters: Vec<char>, target: char) -> char {
        
        let mut left = 0;
        let mut right = letters.len() - 1;
        while left <= right {
            let mid = left + (right - left) / 2;
            if letters[mid] > target {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if left >= letters.len() {
            letters[0]
        } else {
            letters[left]
        }
    }
}