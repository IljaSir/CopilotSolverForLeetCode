impl Solution {
    pub fn can_arrange(arr: Vec<i32>, k: i32) -> bool {
        
        let mut counter = vec![0; k as usize];
        for i in arr {
            counter[((i % k) + k) as usize % k as usize] += 1;
        }
        for i in 1..k as usize {
            if counter[i] != counter[k as usize - i] {
                return false;
            }
        }
        counter[0] % 2 == 0
    }
}