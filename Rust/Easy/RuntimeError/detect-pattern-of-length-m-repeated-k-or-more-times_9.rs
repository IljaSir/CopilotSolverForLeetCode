impl Solution {
    pub fn contains_pattern(arr: Vec<i32>, m: i32, k: i32) -> bool {
        
        let mut ans = false;
        let mut len = m as usize;
        let mut rep = k as usize;
        let mut i = 0;
        while i + len * rep <= arr.len() {
            let mut j = 0;
            while j + len <= arr.len() {
                let mut flag = true;
                for r in 1..rep {
                    for c in 0..len {
                        if arr[j + c] != arr[j + c + r * len] {
                            flag = false;
                            break;
                        }
                    }
                    if !flag {
                        break;
                    }
                }
                if flag {
                    ans = true;
                    break;
                }
                j += 1;
            }
            if ans {
                break;
            }
            i += 1;
        }
        ans
    }
}