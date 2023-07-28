impl Solution {
    pub fn find_special_integer(arr: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut cur = arr[0];
        let mut max = 0;
        let mut ret = 0;
        for i in 0..arr.len() {
            if arr[i] == cur {
                count += 1;
            } else {
                if count > max {
                    max = count;
                    ret = cur;
                }
                count = 1;
                cur = arr[i];
            }
        }
        if count > max {
            max = count;
            ret = cur;
        }
        ret
    }
}