impl Solution {
    pub fn path_in_zig_zag_tree(label: i32) -> Vec<i32> {
        
        let mut ans = Vec::new();
        let mut i = label;
        while i > 0 {
            ans.push(i);
            i /= 2;
        }
        let mut j = 0;
        let mut k = ans.len();
        while j < k {
            let mut x = 2i32.pow(j as u32);
            let mut y = 2i32.pow((j + 1) as u32) - 1;
            while x < y {
                ans.swap(x as usize, y as usize);
                x += 1;
                y -= 1;
            }
            j += 1;
            k -= 1;
        }
        ans
    }
}