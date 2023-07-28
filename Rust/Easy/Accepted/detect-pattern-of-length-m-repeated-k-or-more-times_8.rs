impl Solution {
    pub fn contains_pattern(arr: Vec<i32>, m: i32, k: i32) -> bool {
        
        let mut i = 0;
        while i + m * k <= arr.len() as i32 {
            let mut j = i + m;
            let mut count = 1;
            while j + m <= arr.len() as i32 {
                if arr[i as usize..(i + m) as usize] == arr[j as usize..(j + m) as usize] {
                    count += 1;
                    if count == k {
                        return true;
                    }
                } else {
                    break;
                }
                j += m;
            }
            i += 1;
        }
        false
    }
}