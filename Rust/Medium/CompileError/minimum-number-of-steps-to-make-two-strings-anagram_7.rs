impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        
        let mut s = s.as_bytes().to_vec();
        let mut t = t.as_bytes().to_vec();
        s.sort();
        t.sort();
        let mut ans = 0;
        let mut i = 0;
        let mut j = 0;
        while i < s.len() && j < t.len() {
           

======

        le+=m   n;=.no_byts;
t.to_byte;
s.sr
        t.set to;ytes();
    s.sole;mt0.sort();
        le  ;tj  0;        while i < s.len() && j < t.len() {
            if sdiff ==t
        while   <i +len() && j < 1.l;n
         + if[= t[j]{
                 i+=1;
            f j+
            }  1sif[i] < t[j] {
 f+=1;
===dff
         u}selseytes().to_vec();
    let tsye._(j+
              o)diff+1
      let  =}
        let mut j = 0;
      l diff < s.len() && j < t.len() {
            if s[i] == t[j] {
                i += 1;
                j += 1;
            } else if s[i] < t[j] {
                i += 1;
                ans += 1;
            } else {
                j += 1;
                ans += 1;
            }
        }
        anslse if s[i] < t[j] {
                i += 1;
                count += 1;
            } else {
                j += 1;
                count += 1;
            }
        }
        count + (s.len() - i) as i32 + (t.len() - j) as i32
    }
}