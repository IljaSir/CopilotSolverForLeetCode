impl Solution {
    pub fn is_covered(ranges: Vec<Vec<i32>>, left: i32, right: i32) -> bool {
        
        let mut covered = vec![false; (right - left + 1) as usize];
        for range in ranges {
            for i in range[0]..=range[1] {
                if i >= left && i <= right {
                    covered[(i - left) as usize] = true;
                }
            }
        }
        covered.iter().all(|&x| x)
    }
}