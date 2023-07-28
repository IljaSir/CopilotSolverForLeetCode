impl Solution {
    pub fn median_sliding_window(nums: Vec<i32>, k: i32) -> Vec<f64> {
        
        let mut v = vec![];
        let mut i = 0;
        let mut j = k as usize;
        let mut v2 = nums[i..j].to_vec();
        v2.sort();
        let mut m = v2.len() / 2;
        if v2.len() % 2 == 0 {
            v.push((v2[m] + v2[m - 1]) as f64 / 2.0);
        } else {
            v.push(v2[m] as f64);
        }
        i += 1;
        j += 1;
        while j <= nums.len() {
            let mut f = false;
            let mut c = 0;
            while c < v2.len() {
                if nums[i - 1] == v2[c] {
                    v2.remove(c);
                    f = true;
                    break;
                }
                c += 1;
            }
            if !f {
                let mut d = 0;
                while d < v2.len() {
                    if nums[i - 1] < v2[d] {
                        v2.insert(d, nums[i - 1]);
                        break;
                    }
                    d += 1;
                }
            }
            if nums[j - 1] > v2[v2.len() - 1] {
                v2.push(nums[j - 1]);
            } else {
                let mut e = 0;
                while e < v2.len() {
                    if nums[j - 1] < v2[e] {
                        v2.insert(e, nums[j - 1]);
                        break;
                    }
                    e += 1;
                }
            }
            m = v2.len() / 2;
            if v2.len() % 2 == 0 {
                v.push((v2[m] + v2[m - 1]) as f64 / 2.0);
            } else {
                v.push(v2[m] as f64);
            }
            i += 1;
            j += 1;
        }
        v
    }
}