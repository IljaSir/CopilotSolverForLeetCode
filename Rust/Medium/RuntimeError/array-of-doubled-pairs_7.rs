impl Solution {
    pub fn can_reorder_doubled(arr: Vec<i32>) -> bool {
        
        let mut arr = arr;
        arr.sort_unstable();
        let mut count = vec![0; 200001];
        for &num in &arr {
            count[(num + 100000) as usize] += 1;
        }
        for &num in &arr {
            if count[(num + 100000) as usize] == 0 {
                continue;
            }
            count[(num + 100000) as usize] -= 1;
            if num < 0 && num % 2 != 0 {
                return false;
            }
            let target = if num < 0 { num / 2 } else { num * 2 };
            if count[(target + 100000) as usize] == 0 {
                return false;
            }
            count[(target + 100000) as usize] -= 1;
        }
        true
    }
}