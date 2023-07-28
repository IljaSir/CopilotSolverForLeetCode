impl Solution {
    pub fn can_reorder_doubled(arr: Vec<i32>) -> bool {
        
        let mut arr = arr;
        arr.sort_unstable();
        let mut i = 0;
        while i < arr.len() {
            if arr[i] < 0 {
                if arr[i] % 2 != 0 {
                    return false;
                } else {
                    let mut j = i + 1;
                    while j < arr.len() {
                        if arr[j] == arr[i] / 2 {
                            arr.remove(j);
                            arr.remove(i);
                            i -= 1;
                            break;
                        } else {
                            j += 1;
                        }
                    }
                    if j == arr.len() {
                        return false;
                    }
                }
            } else {
                let mut j = i + 1;
                while j < arr.len() {
                    if arr[j] == arr[i] * 2 {
                        arr.remove(j);
                        arr.remove(i);
                        i -= 1;
                        break;
                    } else {
                        j += 1;
                    }
                }
                if j == arr.len() {
                    return false;
                }
            }
            i += 1;
        }
        true
    }
}