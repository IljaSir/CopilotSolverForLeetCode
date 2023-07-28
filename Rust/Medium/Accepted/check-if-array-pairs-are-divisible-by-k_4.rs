impl Solution {
    pub fn can_arrange(arr: Vec<i32>, k: i32) -> bool {
        
        let mut map = vec![0; k as usize];
        for &i in arr.iter() {
            map[((i % k) + k) as usize % k as usize] += 1;
        }
        for i in 1..(k as usize / 2 + 1) {
            if map[i] != map[k as usize - i] {
                return false;
            }
        }
        map[0] % 2 == 0
    }
}