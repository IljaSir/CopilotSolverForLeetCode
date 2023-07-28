impl Solution {
    pub fn next_greatest_letter(letters: Vec<char>, target: char) -> char {
        
        let mut l = 0;
        let mut r = letters.len() - 1;
        while l <= r {
            let mid = l + (r - l) / 2;
            if letters[mid] <= target {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        letters[l % letters.len()]
    }
}