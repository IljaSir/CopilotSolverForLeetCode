impl Solution {
    pub fn convert_time(current: String, correct: String) -> i32 {
        
        let mut c = current.split(':').collect::<Vec<_>>();
        let mut co = correct.split(':').collect::<Vec<_>>();
        let mut h = c[0].parse::<i32>().unwrap();
        let mut m = c[1].parse::<i32>().unwrap();
        let mut ho = co[0].parse::<i32>().unwrap();
        let mut mo = co[1].parse::<i32>().unwrap();
        let mut ans = 0;
        if ho < h {
            ho += 24;
        }
        if mo < m {
            mo += 60;
            ho -= 1;
        }
        let mut diff = (ho - h) * 60 + (mo - m);
        let mut a = [60, 15, 5, 1];
        for i in 0..4 {
            ans += diff / a[i];
            diff %= a[i];
        }
        ans
    }
}